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
  
  title = '';
    snippet = '';
      body = '';

  constructor(private service: RESTAPIService, private router: Router) { }

  ngOnInit(): void {
  }

  saveBlog() {

    let blog = {      title: this.title,      snippet: this.snippet,      body: this.body    };

    this.service.postBlog(blog).subscribe({
      error: (err) => { console.error(err) },
      complete: () => { this.router.navigate(['viewblogs']) }
    });
  }
}
