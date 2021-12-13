import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SneakerFormComponent } from './sneaker-form.component';

describe('SneakerFormComponent', () => {
  let component: SneakerFormComponent;
  let fixture: ComponentFixture<SneakerFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SneakerFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SneakerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
