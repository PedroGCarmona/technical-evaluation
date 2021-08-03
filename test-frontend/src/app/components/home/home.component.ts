import { Component, OnInit } from '@angular/core';
import { HomeService } from 'src/app/services/home/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public searchParam = '';

  constructor(public homeService : HomeService) { }

  ngOnInit(): void {
  }

  public search(): void{
    this.homeService.search(this.searchParam).subscribe((result : any) =>{
      console.log(result);
    })
  }

}
