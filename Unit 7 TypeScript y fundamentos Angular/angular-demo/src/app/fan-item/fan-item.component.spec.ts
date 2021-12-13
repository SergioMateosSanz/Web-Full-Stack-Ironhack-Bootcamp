import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FanItemComponent } from './fan-item.component';

describe('FanItemComponent', () => {
  let component: FanItemComponent;
  let fixture: ComponentFixture<FanItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FanItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FanItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
