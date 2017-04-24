import { AngularDirectivesPage } from './app.po';

describe('angular-directives App', () => {
  let page: AngularDirectivesPage;

  beforeEach(() => {
    page = new AngularDirectivesPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
