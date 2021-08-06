import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from 'src/app/components/dto/item';
import { Query } from 'src/app/components/dto/query';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private httpClient: HttpClient) { }

  public search(searchParam: string): Observable<Query>{
    let params = new HttpParams().set('searchParam', searchParam);
    let result =  this.httpClient.get<Query>("http://pedrogcarmona-backend.us-east-1.elasticbeanstalk.com/", {params: params});
    return result;
  }

}
