import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotationVehiculeNonDoteAjouterComponent } from './dotation-vehicule-non-dote-ajouter.component';

describe('DotationVehiculeNonDoteAjouterComponent', () => {
  let component: DotationVehiculeNonDoteAjouterComponent;
  let fixture: ComponentFixture<DotationVehiculeNonDoteAjouterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DotationVehiculeNonDoteAjouterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DotationVehiculeNonDoteAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
