import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from 'src/app/common/hotel';
import { HotelServiceService } from 'src/app/hotel-service.service';

@Component({
  selector: 'app-hotelsetting',
  templateUrl: './hotelsetting.component.html',
  styleUrls: ['./hotelsetting.component.css']
})
export class HotelsettingComponent {
  hotels:Hotel[];
  constructor(private hotelService:HotelServiceService,public router:Router,private activateRoute:ActivatedRoute) 
  {

   }

  ngOnInit(): void 
  {
    this.activateRoute.paramMap.subscribe(()=>this.getAllhotels());
  }
 
getAllhotels(): void
{
  this.hotelService.getAllhotel().subscribe(data=>{
    console.log(data);
    this.hotels=data;
  });

}
addHotel():void
{
  this.router.navigateByUrl("/hotelform")
}
bookhotel():void
{
  this.router.navigateByUrl("/bookhotel")
}

updatehotel(hotel_id:number)
{
  this.router.navigateByUrl("/updatehotel/"+hotel_id);
}
deletehotel(hotel_id : Number){
  console.log(hotel_id);
  if(confirm("Do you want to delete ?")){
    this.hotelService.deletehotel(hotel_id).subscribe(data=>{
      console.log(data);
      this.getAllhotels();
    })
  };
}

}

