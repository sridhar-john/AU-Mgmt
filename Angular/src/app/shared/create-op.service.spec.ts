import { TestBed } from '@angular/core/testing';

import { CreateOpService } from './create-op.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('CareteOpService', () => {
  let service: CreateOpService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(CreateOpService);
  });

 /* it('should be created', () => {
    expect(service).toBeTruthy();
  });*/
});
