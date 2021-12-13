import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnguMaterialComponent } from './angu-material.component';

describe('AnguMaterialComponent', () => {
  let component: AnguMaterialComponent;
  let fixture: ComponentFixture<AnguMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnguMaterialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnguMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
