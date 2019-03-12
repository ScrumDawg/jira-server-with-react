import React, { Component } from 'react';
import styled from 'styled-components';
import DynamicTable from '@atlaskit/dynamic-table';
import Page, { Grid, GridColumn } from '@atlaskit/page';
import { caption, head, rowsPerson, rowsCompany } from './sample-data/sample-data';
import { Fetch } from 'react-data-fetching';



class IssueContactPanel extends Component{

    constructor(props){
        super(props);

        this.state = {
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
                    </GridColumn>
                </Grid>
            </Page>
        );
    }
}

export default IssueContactPanel;