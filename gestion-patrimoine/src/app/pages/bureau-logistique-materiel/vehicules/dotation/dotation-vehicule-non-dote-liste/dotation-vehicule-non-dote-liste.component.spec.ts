import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotationVehiculeNonDoteListeComponent } from './dotation-vehicule-non-dote-liste.component';

describe('DotationVehiculeNonDoteListeComponent', () => {
  let component: DotationVehiculeNonDoteListeComponent;
  let fixture: ComponentFixture<DotationVehiculeNonDoteListeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DotationVehiculeNonDoteListeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DotationVehiculeNonDoteListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
