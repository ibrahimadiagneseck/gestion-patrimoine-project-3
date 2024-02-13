import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotationVehiculeVehiculeAjouterComponent } from './dotation-vehicule-vehicule-ajouter.component';

describe('DotationVehiculeVehiculeAjouterComponent', () => {
  let component: DotationVehiculeVehiculeAjouterComponent;
  let fixture: ComponentFixture<DotationVehiculeVehiculeAjouterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DotationVehiculeVehiculeAjouterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DotationVehiculeVehiculeAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
