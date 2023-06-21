import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RESTAPIService {

  constructor(private http: HttpClient) { }

  requestOptions: Object = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    responseType: 'text'
  }

  estimateAlgoService(blog: any): Observable<string> {
    {
      //This url needs to go some constant file.
      let url = "http://localhost:8080/api/algoCheck";
      return this.http.post<string>(url, blog, this.requestOptions);
    }
  }
}
