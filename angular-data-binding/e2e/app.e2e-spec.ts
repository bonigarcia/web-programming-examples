import { AngularDataBindingPage } from './app.po';

describe('angular-data-binding App', () => {
  let page: AngularDataBindingPage;

  beforeEach(() => {
    page = new AngularDataBindingPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
