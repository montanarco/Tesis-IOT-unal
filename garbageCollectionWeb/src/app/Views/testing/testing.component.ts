import { Component, OnInit } from '@angular/core';
import { RoutingService } from 'src/app/services/routing-service';

@Component({
  selector: 'testing',
  templateUrl: './testing.component.html',
  styleUrls: ['./testing.component.css']
})
export class TestingComponent implements OnInit {

  constructor(private routingService: RoutingService) { }

  ngOnInit() {
  }


}
