import React, { Component } from 'react';
import styled from 'styled-components';
import DynamicTable from '@atlaskit/dynamic-table';
import Page, { Grid, GridColumn } from '@atlaskit/page';
import { caption, head, rowsPerson, rowsCompany } from './sample-data/sample-data';
import Button from '@atlaskit/button';

import { Fetch } from 'react-data-fetching';

import AddIssueContactDialog from './../../AddIssueContactDialog/AddIssueContactDialog'

class IssueContactPanel extends Component{

    state = {
        isOpen: false,
        contacts: [],
    };

    open = () => this.setState({ isOpen: true });
    close = () => this.setState({ isOpen: false });
    onFormSubmit = (data) => {
        console.log(JSON.stringify(data));
        close();
    }

    constructor(props){
        super(props);

        this.state = {
            isOpen: false,
            contacts: [],
        };
    }

    componentDidMount() {
        /*fetch(API + DEFAULT_QUERY)
            .then(response => response.json())
            .then(data => this.setState({ hits: data.hits }));*/
    }

    render(){
        return (
            <Page>
                <Grid>
                    <GridColumn medium={12}>
                        <h4>Persons</h4>
                        <DynamicTable
                            head={head}
                            rows={rowsPerson}
                            rowsPerPage={3}
                            defaultPage={1}
                            loadingSpinnerSize="large"
                            isLoading={false}
                            isFixedSize
                            defaultSortKey="term"
                            defaultSortOrder="ASC"
                            onSort={() => console.log('onSort')}
                            onSetPage={() => console.log('onSetPage')}
                        />
                        <h4>Companies</h4>
                        <DynamicTable
                            head={head}
                            rows={rowsCompany}
                            rowsPerPage={3}
                            defaultPage={1}
                            loadingSpinnerSize="large"
                            isLoading={false}
                            isFixedSize
                            defaultSortKey="term"
                            defaultSortOrder="ASC"
                            onSort={() => console.log('onSort')}
                            onSetPage={() => console.log('onSetPage')}
                        />

                        <Button onClick={this.open}>Open Modal</Button>
                    </GridColumn>
                </Grid>
                {this.state.isOpen && (
                    <AddIssueContactDialog
                        close={this.close}
                        onFormSubmit={this.onFormSubmit}
                    />
                )}
            </Page>
        );
    }
}

export default IssueContactPanel;