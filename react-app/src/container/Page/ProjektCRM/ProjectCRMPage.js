import React, { Component } from 'react';
import styled from 'styled-components';
import Page, { Grid, GridColumn } from '@atlaskit/page';

import EmailForm from './../../NewEmailDialog/EmailForm/EmailForm'

const Dummy = styled.div`
  background: #fea;
`;

export default class ProjectCRMPage extends Component{


    render(){

        return (
            <div>
                <Page>
                    <Grid layout="fluid">
                        <GridColumn medium={4}>
                            <EmailForm/>
                        </GridColumn>
                        <GridColumn medium={4}>
                            <Dummy>4 col</Dummy>
                        </GridColumn>
                        <GridColumn medium={3}>
                            <Dummy>3 col</Dummy>
                        </GridColumn>
                        <GridColumn medium={1}>
                            <Dummy>1 col</Dummy>
                        </GridColumn>
                        <GridColumn>
                            <Dummy>Unspecified</Dummy>
                        </GridColumn>
                    </Grid>
                </Page>
            </div>
        );
    }
}