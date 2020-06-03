import { TestBed } from '@angular/core/testing';

import { CreateOpService } from './create-op.service';

describe('CareteOpService', () => {
  let service: CreateOpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateOpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
