import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { catchError } from 'rxjs/operators';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
        
    constructor(private http:Http){}
    private baseUrl:string = 'http://localhost:8080';
    public submitted:boolean;
    roomsearch : FormGroup;
    rooms: Room[];
    
        ngOnInit(){
         this.roomsearch = new FormGroup({
             checkIn: new FormControl(''),
             checkOut: new FormControl('')
          });  
            
         }
        onSubmit({value,valid}: {value:Roomsearch, valid:boolean}){
            this.getAll()
            .subscribe(rooms => this.rooms = rooms,
                err => {
                    console.log(err);
                    });
        }
        
        reserveRoom(id:string){
            console.log(id);
        }
    
        getAll(): Observable<Room[]>{
            return this.http.get(this.baseUrl + '/room/reservation/v1?checkIn=2017-03-17&checkOut=2017-03-19')
            .map(this.mapRoom);    
        }
    
        mapRoom(response:Response):Room[]{
            console.log(response.json().content);
            return response.json().content;
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
    
   
