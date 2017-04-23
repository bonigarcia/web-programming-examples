import { AngularHelloWorldPage } from './app.po';

describe('angular-hello-world App', () => {
  let page: AngularHelloWorldPage;

  beforeEach(() => {
    page = new AngularHelloWorldPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
