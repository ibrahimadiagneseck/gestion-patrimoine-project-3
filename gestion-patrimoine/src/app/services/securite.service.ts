
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import * as CryptoJS from 'crypto-js';

@Injectable({
    providedIn: 'root'
})
export class SecuriteService {

    private tokenFromUI = environment.tokenFromUI;


    constructor() {
        // this.encryptUsingAES256();
    }

    encryptUsingAES256(request: string): string {
        let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
        let _iv = CryptoJS.lib.WordArray.random(16);
        let encrypted = CryptoJS.AES.encrypt(
            JSON.stringify(request), _key, {
            // keySize: 16,
            keySize: 16,
            iv: _iv,
            mode: CryptoJS.mode.ECB,
            padding: CryptoJS.pad.Pkcs7
        });
        return encrypted.toString();
    }

    decryptUsingAES256(encrypted: string): string {
        let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
        let _iv = CryptoJS.enc.Utf8.parse(this.tokenFromUI);

        let decrypted = CryptoJS.AES.decrypt(
            encrypted, _key, {
            keySize: 16,
            iv: _iv,
            mode: CryptoJS.mode.ECB,
            padding: CryptoJS.pad.Pkcs7
        }
        ).toString(CryptoJS.enc.Utf8);

        return decrypted.substring(1, decrypted.length - 1);
    }




    // encryptUsingAES256(request: string): string {
    //     let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    //     let _iv = CryptoJS.lib.WordArray.random(16); // Utilisez un IV aléatoire
    //     let encrypted = CryptoJS.AES.encrypt(
    //         JSON.stringify(request), _key, {
    //         keySize: 32, // Utilisez une clé de 32 octets pour AES-256
    //         iv: _iv,
    //         mode: CryptoJS.mode.CBC, // Utilisez le mode CBC
    //         padding: CryptoJS.pad.Pkcs7
    //     });
    //     return encrypted.toString();
    // }
    
    // decryptUsingAES256(encrypted: string): string {
    //     let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    //     let _iv = CryptoJS.enc.Hex.parse(encrypted.substr(0, 32)); // Récupérez l'IV du début du texte chiffré
    
    //     return CryptoJS.AES.decrypt(
    //         encrypted.substring(32), _key, { // Excluez l'IV du texte chiffré
    //         keySize: 32,
    //         iv: _iv,
    //         mode: CryptoJS.mode.CBC,
    //         padding: CryptoJS.pad.Pkcs7
    //     }
    //     ).toString(CryptoJS.enc.Utf8);
    // }
    



    // tokenFromUI: string = "0123456789123456";
    // encrypted: any = "";
    // decrypted: string;

    // request: string;
    // responce: string;
    // constructor() {
    //     this.encryptUsingAES256();
    // }
    // encryptUsingAES256() {
    //     let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    //     let _iv = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    //     let encrypted = CryptoJS.AES.encrypt(
    //         JSON.stringify(this.request), _key, {
    //         keySize: 16,
    //         iv: _iv,
    //         mode: CryptoJS.mode.ECB,
    //         padding: CryptoJS.pad.Pkcs7
    //     });
    //     this.encrypted = encrypted.toString();
    // }
    // decryptUsingAES256() {
    //     let _key = CryptoJS.enc.Utf8.parse(this.tokenFromUI);
    //     let _iv = CryptoJS.enc.Utf8.parse(this.tokenFromUI);

    //     this.decrypted = CryptoJS.AES.decrypt(
    //         this.encrypted, _key, {
    //         keySize: 16,
    //         iv: _iv,
    //         mode: CryptoJS.mode.ECB,
    //         padding: CryptoJS.pad.Pkcs7
    //     }).toString(CryptoJS.enc.Utf8);
    // }



    
  // encryptId(id: string, key: string): string {
  //   return CryptoJS.HmacSHA512(id, key).toString(CryptoJS.enc.Base64);
  // }

  // decryptId(encryptedId: string, key: string): string {
  //   return CryptoJS.HmacSHA512(CryptoJS.enc.Base64.parse(encryptedId), key).toString();
  // }

}
