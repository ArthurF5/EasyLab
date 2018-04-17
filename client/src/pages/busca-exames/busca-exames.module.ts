import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { BuscaExamesPage } from './busca-exames';

@NgModule({
  declarations: [
    BuscaExamesPage,
  ],
  imports: [
    IonicPageModule.forChild(BuscaExamesPage),
  ],
})
export class BuscaExamesPageModule {}
