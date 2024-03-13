import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardDisheComponent } from './card-dishe.component';

describe('CardDisheComponent', () => {
  let component: CardDisheComponent;
  let fixture: ComponentFixture<CardDisheComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CardDisheComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CardDisheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
