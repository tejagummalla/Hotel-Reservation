import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
    public submitted:boolean;
    roomsearch : FormGroup;
    rooms: Room[];
    
        ngOnInit(){
         this.roomsearch = new FormGroup({
             checkIn: new FormControl(''),
             checkOut: new FormControl('')
          });  
            
            this.rooms = ROOMS;
         }
        onSubmit({value,valid}: {value:Roomsearch, valid:boolean}){
            console.log(value)
        }
        
        reserveRoom(id:string){
            console.log(id);
        }
    
}

   export interface Roomsearch {
        checkIn:string;
        checkOut:string;
   }
    
    export interface Room{
        id:string;
        roomNumber:string;
        price:string;
        links:string;
     }
    
    var ROOMS:Room[] = [
    {
            "id" : "1234",
            "roomNumber": "409",
            "price": "100",
            "links":""
    },
    {
            "id" : "2345",
            "roomNumber": "419",
            "price": "100",
            "links":""
    },
    {
            "id" : "3456",
            "roomNumber": "429",
            "price": "100",
            "links":""
    }]
