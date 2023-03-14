import { TestBed } from '@angular/core/testing';

import { RESTAPIServiceService } from './restapiservice.service';

describe('RESTAPIServiceService', () => {
  let service: RESTAPIServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RESTAPIServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
