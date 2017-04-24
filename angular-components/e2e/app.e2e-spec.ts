import { AngularComponentsPage } from './app.po';

describe('angular-components App', () => {
  let page: AngularComponentsPage;

  beforeEach(() => {
    page = new AngularComponentsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
