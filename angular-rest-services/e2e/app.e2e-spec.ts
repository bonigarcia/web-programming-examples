import { AngularRestServicesPage } from './app.po';

describe('angular-rest-services App', () => {
  let page: AngularRestServicesPage;

  beforeEach(() => {
    page = new AngularRestServicesPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
