import { AppPage } from './app.po';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display About title', () => {
    page.navigateTo();
    expect(page.getHomePageTitle()).toEqual('About');
  });
});
