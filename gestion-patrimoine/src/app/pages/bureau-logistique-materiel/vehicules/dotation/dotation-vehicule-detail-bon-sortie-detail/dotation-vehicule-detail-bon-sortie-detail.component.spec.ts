import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DotationVehiculeDetailBonSortieDetailComponent } from './dotation-vehicule-detail-bon-sortie-detail.component';

describe('DotationVehiculeDetailBonSortieDetailComponent', () => {
  let component: DotationVehiculeDetailBonSortieDetailComponent;
  let fixture: ComponentFixture<DotationVehiculeDetailBonSortieDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DotationVehiculeDetailBonSortieDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DotationVehiculeDetailBonSortieDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
