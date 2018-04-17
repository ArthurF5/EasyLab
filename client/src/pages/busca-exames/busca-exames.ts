import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-busca-exames',
  templateUrl: 'busca-exames.html',
})
export class BuscaExamesPage {
  items;
  constructor(
    public navCtrl: NavController,
    public navParams: NavParams) {
    this.initializeItems();
  }
  initializeItems() {
    this.items = [
      'exame01',
      'exame02',
      'exame03',
      'exame04',
      'exame05',
      'exame06',
      'exame07',
      'exame08',
      'exame09',
      'exame10',
      'exame11',
      'exame12',
      'exame13'
    ];
  }

  onInput(event) {
    this.initializeItems();
    var val = event.target.value;
    if (val && val.trim() != '') {
      this.items = this.items.filter((item) => {
        return (item.toLowerCase().indexOf(val.toLowerCase()) > -1);
      })
    }
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad BuscaExamesPage');
  }

}
