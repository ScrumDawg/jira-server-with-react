import React, { Component } from 'react';
import EmailForm from './EmailForm/EmailForm'
import Button from '@atlaskit/button';

import Form, { Field, CheckboxField } from '@atlaskit/form';
import { Checkbox } from '@atlaskit/checkbox';
import Textfield from '@atlaskit/textfield';
import RadioGroup, { AkRadio } from '@atlaskit/field-radio-group';

class NewEmailDialog extends Component {


    render() {
        return (
            <div>
                <EmailForm/>
            </div>
        );
    }
}

export default NewEmailDialog;