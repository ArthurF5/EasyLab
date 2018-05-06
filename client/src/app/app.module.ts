import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { HeaderComponent } from './../components/header/header';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { HttpModule } from '@angular/http';

import { MyApp } from './app.component';

import { HomePage } from '../pages/home/home';
import { ListPage } from '../pages/list/list';
import { ExamesPage } from './../pages/exames/exames';
import { BuscaExamesPage } from './../pages/busca-exames/busca-exames';
import { LoginPage } from './../pages/login/login';
import { CadastroPage } from './../pages/cadastro/cadastro';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { RestProvider } from '../providers/rest/rest';

@NgModule({
  declarations: [
    MyApp,
    CadastroPage,
    LoginPage,
    BuscaExamesPage,
    ExamesPage,
    HeaderComponent,
    HomePage,
    ListPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp,{
      menuType: 'overlay'
    }),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    CadastroPage,
    LoginPage,
    ExamesPage,
    BuscaExamesPage,
    HomePage,
    ListPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    RestProvider
  ]
})
export class AppModule {}
