import { Component, OnInit} from '@angular/core';
import { HomeService } from 'src/app/services/home/home.service';
import { Item } from '../dto/item';
import { Query } from '../dto/query';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public searchParam = '';
  public searchResults: Query = {
    items: []
  };

  constructor(public homeService : HomeService) { }

  ngOnInit(): void {
  }

  public search(): void {
   this.homeService.search(this.searchParam).subscribe((result: Query) => this.searchResults  = result);
  }

}
