import { Component, OnInit, ViewChild } from '@angular/core';
import { } from 'googlemaps';
import { ContainerService } from 'src/app/services/container-service.service';
import { IDumpsterMeasure, Priority } from 'src/app/models/IDumpsterMeasure';

@Component({
  selector: 'app-measures',
  templateUrl: './measures.component.html',
  styleUrls: ['./measures.component.css']
})
export class MeasuresComponent implements OnInit {

  containersLst: IDumpsterMeasure[];
  markers: google.maps.Marker[] = [];
  arrStreetPath = [];
  features: any[];
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

  @ViewChild('map') private mapElement: any;
  map: google.maps.Map;

  constructor(
    private containerService: ContainerService,
  ) { }

  ngOnInit(): void {
    const mapProperties = {
      center: new google.maps.LatLng(4.628721,-74.0935991),
      zoom: 16.5 ,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    setTimeout(() => {
      this.map = new google.maps.Map(this.mapElement.nativeElement, mapProperties);
    }, 1000);
    this.drawContainers();
  }

  drawContainers() {
    this.containerService.searchForRealContainer().subscribe(
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
