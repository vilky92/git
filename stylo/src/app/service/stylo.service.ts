import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http'


import { Stylo } from '../classe/stylo'


@Injectable({
    providedIn: 'root',
})


export class StyloService {
    url = "http://localhost:8181/stylo";
    stylo: Stylo;

    constructor(private http: HttpClient) {
    }

    getStylo(): Observable<any> {
        return this.http.get<Stylo[]>(this.url+"/getAll")
    }

    getOneStylo(id: number): Observable<any> {
        return this.http.get<Stylo>(this.url+"/get/"+`${id}`)
    }

    addStylo(stylo: Stylo): Observable<any>{
        return this.http.post(this.url+"/post", stylo);
    }

    deleteStylo(id: number): Observable<any>{
        return this.http.delete(this.url+"/delete/"+ `${id}`);
    }
}