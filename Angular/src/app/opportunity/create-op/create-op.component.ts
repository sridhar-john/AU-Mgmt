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

  
  
  onClear()
  {
    this.service.form.reset();
    this.service.initializeFormGroup();
  }

  public opp =[];
 
  submit_message:any;
  update_message:any;
  
  onSubmit()
  {
      
    if(this.service.form.valid)
    {
       
      if(!this.service.form.get('id').value)
       {
        
          let res=this.service.insertOpportunity(this.service.form.value);
          res.subscribe((data)=>{
            this.submit_message=data;
            
          });
        }
        else{
          let resp=this.service.updateOpportunity(this.service.form.value);
          resp.subscribe((data)=>{
            this.update_message=data;
           
          });

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
  ngOnInit(){
 

   
  }
  
     
 }


