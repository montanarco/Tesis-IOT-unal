import { ClusterService } from './../../Services/cluster.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { IDumpsterMeasure, Priority } from 'src/app/models/IDumpsterMeasure';
import { } from 'googlemaps';
import { Location } from 'src/app/models/Type';
import { ContainerService } from 'src/app/services/container-service.service';
import { DailyOperationService } from 'src/app/services/daily-operation.service';
import { DatePipe } from '@angular/common';
import { IKmeansResult } from 'src/app/models/IDailyOperation';
import * as moment from 'moment';
import { CustomMessage } from '../CustomMessage';
@Component({
  selector: 'app-simulation',
  templateUrl: './simulation.component.html',
  styleUrls: ['./simulation.component.css']
})
export class SimulationComponent implements OnInit {
  containersLst: IDumpsterMeasure[];
  allowCluster = false;
  kmeanResult: IKmeansResult;
  valueFecha: Date;
  arrStreetPath = [];
  arrColours = ['#FF0000', '#FF8000', '#FFFF00', '#80FF00', '#00FF00', '#00FFBF', '#0080FF', '#0000FF', '#BF00FF', '#FF00BF', '#FE2E64'];

  @ViewChild('map') private mapElement: any;

  map: google.maps.Map;
  iconBase = './assets/images/1x/';
  icons = {
    whiteDumpster: { icon: this.iconBase + 'baseline_delete_white.png' },
    blackDumpster: {
      icon: this.iconBase + 'baseline_delete_black.png'
    },
    greenDumpster: {
      icon: this.iconBase + 'baseline_delete_green.png'
    },
    orangeDumpster: {
      icon: this.iconBase + 'baseline_delete_orange.png'
    },
    redDumpster: {
      icon: this.iconBase + 'baseline_delete_red.png'
    },
    yellowDumpster: {
      icon: this.iconBase + 'baseline_delete_yellow.png'
    }
  };
  features: any[];
  streetLst: any[];
  markers: google.maps.Marker[] = [];
  txtDate: string;

  constructor(private containerService: ContainerService,
    private dailyOperationService: DailyOperationService,
    private clusterService: ClusterService,
    private datepipe: DatePipe,
    private messajeService: CustomMessage) {

  }

  ngOnInit(): void {
    const mapProperties = {
      center: new google.maps.LatLng(4.7186192, -74.1244244),
      zoom: 14,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    setTimeout(() => {
      this.map = new google.maps.Map(this.mapElement.nativeElement, mapProperties);
    }, 1000);
  }

  clusterStreets() {

    this.clusterService.clusterStreets(this.txtDate).subscribe(
      response => {
        this.kmeanResult = response;
        if (this.kmeanResult) {
          this.deleteMarkers();
          this.configStreetMap();
          this.addStreets();
          this.arrStreetPath.forEach(i => i.setMap(this.map));
        }
      }
    );
  }

  configStreetMap() {
    this.streetLst = [];
    let contador = 0;
    for (const cluster of this.kmeanResult.clusters) {
      for (const itemPunto of cluster.puntos) {
        //new google.maps.LatLng(punto[0], punto[1])
        var flightPlanCoordinates = itemPunto.via.geom.coordinates[0].map(i => (new google.maps.LatLng(i[1], i[0])));
        this.streetLst.push({
          coordinates: flightPlanCoordinates,
          colour: this.arrColours[contador]
        });
      }
      contador++;

    }
  }


  addStreets() {
    for (var i = 0; i < this.streetLst.length; i++) {
      var streetPath = new google.maps.Polyline({
        path: this.streetLst[i].coordinates,
        geodesic: true,
        strokeColor: this.streetLst[i].colour,
        strokeOpacity: 1.0,
        strokeWeight: 2
      });
      this.arrStreetPath.push(streetPath);
    };
  }

  generateContainer(filled: boolean) {
    if (filled && this.txtDate == null){
      this.messajeService.showWarn("Fecha Invalida", "profavor seleccione una fecha para simular");
      return;
    }

    this.containerService.generateContainers(filled, this.txtDate).subscribe(
      response => {

        this.containersLst = response;
        if (this.containersLst) {
          this.deleteMarkers();

          this.generateConfigMap();
          this.addMarkes();
        }
      }
    );
  }

  deleteMarkers() {
    this.markers.forEach(i => i.setMap(null));
    this.arrStreetPath.forEach(i => i.setMap(null));
  }

  addMarkes() {
    for (var i = 0; i < this.features.length; i++) {
      var marker = new google.maps.Marker({
        position: this.features[i].position,
        icon: this.features[i].type.icon,
        map: this.map
      });
      this.markers.push(marker);
    };
  }

  generateConfigMap() {
    this.features = [];
    for (const container of this.containersLst) {
      const point = container.idDumpster.location.coordinates;
      this.features.push({
        position: new google.maps.LatLng(parseFloat(point[1] + ''), parseFloat(point[0] + '')),
        type: this.priorityIcon(container.priority)
      });
    }

  }

  fetchDailyOperation() {

    this.dailyOperationService.fetchDailyOperation(this.txtDate).subscribe(
      response => {
        this.allowCluster = response > 0;
      }
    );

  }
  createDailyOperation() {

    this.dailyOperationService.createDailyOperation(this.txtDate).subscribe(
      response => {
        if (response) {
          this.allowCluster = true;
          alert('Se ha creado correctamente la operacion del dia ' + this.txtDate);
          
        } else {
          alert('hubo un error creando la operacion del dia ' + this.txtDate);
        }
      }
    );
  }
  selectedDate() {
    this.txtDate = moment(this.valueFecha).format('DD-MM-YYYY');
    this.fetchDailyOperation();
    this.deleteMarkers();
  }




  priorityIcon(priority: Priority) {
    switch (priority.priorityName) {
      case "Full":
        return this.icons.redDumpster;
      case "High":
        return this.icons.orangeDumpster;
      case "Medium":
        return this.icons.yellowDumpster;
      case "Low":
        return this.icons.greenDumpster;
      case "Empty":
        return this.icons.blackDumpster;
      default:
        return this.icons.whiteDumpster;
    }

  }

}
