import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import { CreateOpService} from "../../shared/create-op.service";
import { NotificationService} from "../../shared/notification.service";

@Component({
  selector: 'app-create-op',
  templateUrl: './create-op.component.html',
  styleUrls: ['./create-op.component.css']
})
export class CreateOpComponent implements OnInit {


  constructor(public service: CreateOpService,public notificationService: NotificationService,public dialogRef:MatDialogRef<CreateOpComponent>) { }

  
  experience=[
    {id:1,value:1},
    {id:2,value:2},
    {id:3,value:3},
    {id:3,value:4},
    {id:3,value:5},
    {id:3,value:6},
    {id:3,value:7},
    {id:3,value:8},
    {id:3,value:9},
    {id:3,value:10}
  ];
  location=[
    {id:1,value:"Banglore"},
    {id:2,value:"Chennai"},
    {id:3,value:"Hyderabad"},
    {id:4,value:"Mumbai"}
  ];
  
  onClear()
  {
    this.service.form.reset();
    this.service.initializeFormGroup();
  }
  js:string;
  us:string;
  jd:Date;
  ud:Date;




  public opp =[];
 
  message:string;
  
  onSubmit()
  {
      
    if(this.service.form.valid)
    {
       
      if(!this.service.form.get('id').value)
       {
          this.js=this.jd.toDateString();
          var splited=this.js.split(" ",4);
          this.js=splited[2]+"/"+splited[1]+"/"+splited[3];
          this.us=this.ud.toDateString();
          var splited1=this.us.split(" ",4);
          this.us=splited1[2]+"/"+splited1[1]+"/"+splited1[3];
          this.service.form.patchValue( {
             joining_date:this.js,
              updated_date:this.us
           }
          );
          console.log(this.service.form.value);
        
          let res=this.service.insertOpportunity(this.service.form.value);
          res.subscribe((data)=>console.log(data));
        }
        else{
          this.js=this.jd.toDateString();
          var splited=this.js.split(" ",4);
          this.js=splited[2]+"/"+splited[1]+"/"+splited[3];
          this.us=this.ud.toDateString();
          var splited1=this.us.split(" ",4);
          this.us=splited1[2]+"/"+splited1[1]+"/"+splited1[3];
          this.service.form.patchValue( {
             joining_date:this.js,
              updated_date:this.us});
         
          console.log("inside update");
          console.log(this.service.form.value);
          let resp=this.service.upadteOpportunity(this.service.form.value);
          resp.subscribe((data)=>console.log(data));

        }

          this.service.form.reset();
          this.service.initializeFormGroup();
          this.notificationService.sucess("Submited successfully!!");
          this.onClose();
    }
  }
  onClose()
  {
    this.service.form.reset();
    this.service.initializeFormGroup();
    this.dialogRef.close();
  }
  ngOnInit(): void {
 
    //  this.service.getOpportunity()
    //  .subscribe(data =>{ this.ds=data;
    // console.log(data);
    // });
    // this.listData = new MatTableDataSource(this.ds);
  }
  
     
 }


