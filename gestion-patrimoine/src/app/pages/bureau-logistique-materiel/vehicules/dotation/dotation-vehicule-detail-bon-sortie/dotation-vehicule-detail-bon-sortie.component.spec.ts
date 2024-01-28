import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotationVehiculeDetailBonSortieComponent } from './dotation-vehicule-detail-bon-sortie.component';

describe('DotationVehiculeDetailBonSortieComponent', () => {
  let component: DotationVehiculeDetailBonSortieComponent;
  let fixture: ComponentFixture<DotationVehiculeDetailBonSortieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DotationVehiculeDetailBonSortieComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DotationVehiculeDetailBonSortieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
