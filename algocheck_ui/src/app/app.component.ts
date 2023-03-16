import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Router } from '@angular/router';
import { RESTAPIService } from './restapiservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  body = '';
  name: any;

  constructor(private service: RESTAPIService, private router: Router) { }

  ngOnInit(): void {
  }

  estimateAlgo() {

    let blog = { body: this.body };
    this.service.estimateAlgoService(blog).subscribe(data => {
      this.name = data;
    },
      err => {
        console.log(err);
      });
  }
}
