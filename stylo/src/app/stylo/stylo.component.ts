import { Component, OnInit } from '@angular/core';
import { StyloService } from '../service/stylo.service'
import { Stylo } from '../classe/Stylo'
import { FormGroup, FormBuilder} from '@angular/forms';
import { isNgTemplate } from '@angular/compiler';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-stylo',
  templateUrl: './stylo.component.html',
  styleUrls: ['./stylo.component.scss']
})
export class StyloComponent implements OnInit {
  stylos: Stylo[];
  stylo: Stylo;
  two: String[];
  styloForm: FormGroup;

  selectedStylo: Stylo;

  constructor(private styloService: StyloService, private fb: FormBuilder) { 
    this.createForm();
  }

  ngOnInit() {
    this.getAllStylo();
    this.initStylo();
    this.stylo = new Stylo();
    this.two = Object.keys(this.stylo);
  }

  
  key() {
    var one = new Stylo();
    let i = 0;
    let j = 0;
    let styl;
    for (let a of this.stylos) {
      j = 0;
      one = this.stylos[i]
      console.log(one)
      console.log()
      i++;
      for (let b in one) {
        styl = `${one[b]}`;
        console.log(styl)
        j++;
      }
    }
  }

  getAllStylo() {
    return this.styloService.getStylo()
    .subscribe(stylo => this.stylos = stylo);
  }
  getOneStylo(id: number) {
    return this.styloService.getOneStylo(id)
    .subscribe(stylo => this.stylo = stylo);
  }

  createForm() {
    this.styloForm = this.fb.group({
      id: 0,
      color: '',
      number: ''
    })
  }

  initStylo(){
    this.selectedStylo = new Stylo();
    this.createForm();
  }

  createStylo() {
    const s = this.styloForm.value;
    console.log("stylo service ici ");
    console.log(this.styloService);
    this.styloService.addStylo(s).subscribe(
      res => {
        console.log("ici res "+res);
        console.log("ici loadproduit "+this.getAllStylo)
        this.initStylo()
        //ici mon getter après avoir fait le post pour avoir mon dashboard mis à jour
        this.getAllStylo();
      }
    );
  }

  delete(id) {
    console.log(id);
    this.styloService.deleteStylo(id).subscribe(
      res => {
        console.log("ici res "+res);
        console.log("ici loadproduit "+this.getAllStylo)
        //je reset mon selectProduit
        this.selectedStylo = new Stylo();
        //ici mon getter après avoir fait le post pour avoir mon dashboard mis à jour
        this.getAllStylo();
        
      }
    );
  }

}
