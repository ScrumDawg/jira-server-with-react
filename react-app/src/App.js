import React, { Component } from 'react';

import ProjectCRMPage from './container/Page/ProjektCRM/ProjectCRMPage';
import IssueContactPanel from './container/Panel/IssueContactPanel/IssueContactPanel';

class App extends Component {
  render() {
    return (
      <div>
          <IssueContactPanel/>
      </div>
    );
  }
}

export default App;
