import { AngularRoutingPage } from './app.po';

describe('angular-routing App', () => {
  let page: AngularRoutingPage;

  beforeEach(() => {
    page = new AngularRoutingPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
