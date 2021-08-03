import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private httpClient: HttpClient) { }

  public search(searchParam: string): Observable<any>{
    let params = new HttpParams()
    .set('searchParam', searchParam);
    return this.httpClient.get("http://localhost:8080/", {params: params});
  }

}
