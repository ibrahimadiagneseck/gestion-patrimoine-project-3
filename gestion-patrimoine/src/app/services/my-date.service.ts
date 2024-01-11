
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import * as CryptoJS from 'crypto-js';
import { DatePipe } from '@angular/common';
import { MyDate } from '../model/my-date.model';

@Injectable({
  providedIn: 'root'
})
export class MyDateService {

  constructor(private datePipe: DatePipe) { }

  public formatterMyDate(myDate: MyDate): string {
    if (!myDate || !myDate.year || !myDate.month || !myDate.day) {
      return '';
    }

    const { year, month, day } = myDate;
    const date = new Date(year, month - 1, day);

    const formattedDate = this.datePipe.transform(date, 'dd MMMM yyyy', 'fr') || '';
    return formattedDate;
  }

  public formatterMyDateFromString(dateString: string): string {
    const date = new Date(dateString);
    const formattedDate = this.datePipe.transform(date, 'dd MMMM yyyy', 'fr') || '';
    return formattedDate;
  }

}
