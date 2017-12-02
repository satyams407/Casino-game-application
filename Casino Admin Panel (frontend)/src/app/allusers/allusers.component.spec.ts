import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllusersComponent } from './allusers.component';

describe('AllusersComponent', () => {
  let component: AllusersComponent;
  let fixture: ComponentFixture<AllusersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllusersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllusersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
