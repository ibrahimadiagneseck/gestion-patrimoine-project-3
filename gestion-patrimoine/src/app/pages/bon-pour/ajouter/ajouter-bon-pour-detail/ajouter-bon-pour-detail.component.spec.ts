import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterBonPourDetailComponent } from './ajouter-bon-pour-detail.component';

describe('AjouterBonPourDetailComponent', () => {
  let component: AjouterBonPourDetailComponent;
  let fixture: ComponentFixture<AjouterBonPourDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AjouterBonPourDetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AjouterBonPourDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
