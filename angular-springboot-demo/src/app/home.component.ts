import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  templateUrl: './home.component.html'
})
export class HomeComponent {

  title = '我的页面';
  greeting = {id:"", content:""};

  constructor(private app: AppService, private http: HttpClient) {
    //http.get('http://localhost:9090').subscribe(data => this.SetGreeting(data));
	http.get('token').subscribe(data => {
	      const token = data['token'];
	      http.get('http://localhost:9090', {headers : new HttpHeaders().set('X-Auth-Token', token)})
	        .subscribe(response => this.SetGreeting(response));
	    }, () => {});
  }

    private SetGreeting(data:any) {
        return this.greeting = data;
    }

  authenticated() { return this.app.authenticated; }

}
