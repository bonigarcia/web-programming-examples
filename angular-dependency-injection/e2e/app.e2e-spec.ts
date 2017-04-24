import { AngularDependencyInjectionPage } from './app.po';

describe('angular-dependency-injection App', () => {
  let page: AngularDependencyInjectionPage;

  beforeEach(() => {
    page = new AngularDependencyInjectionPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
