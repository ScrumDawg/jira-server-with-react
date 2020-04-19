import React, { Component } from 'react';

import Button from '@atlaskit/button';

import Form, { Field, CheckboxField } from '@atlaskit/form';
import { Checkbox } from '@atlaskit/checkbox';
import Textfield from '@atlaskit/textfield';
import RadioGroup, { AkRadio } from '@atlaskit/field-radio-group';
import ModalDialog, { ModalFooter, ModalTransition } from '@atlaskit/modal-dialog';


class AddIssueContactDialog extends Component{



    render() {
        const footer = props => (
            <ModalFooter showKeyline={props.showKeyline}>
                <span />
                <Button appearance="primary" type="submit">
                    Submit to Console
                </Button>
            </ModalFooter>
        );

        const radioItems = [
            { name: 'color', value: 'red', label: 'Red' },
            { name: 'color', value: 'blue', label: 'Blue' },
            { name: 'color', value: 'yellow', label: 'Yellow' },
        ];

        return (
            <div>
                <ModalTransition>
                        <ModalDialog
                            heading="Form Demo"
                            onClose={this.props.close}
                            components={{
                                Container: ({ children, className }) => (
                                    <Form onSubmit={this.props.onFormSubmit}>
                                        {({ formProps }) => (
                                            <form {...formProps} className={className}>
                                                {children}
                                            </form>
                                        )}
                                    </Form>
                                ),
                                Footer: footer,
                            }}
                        >
                            <p>Enter some text then submit the form to see the response.</p>
                            <Field label="Name" name="my-name" defaultValue="">
                                {({ fieldProps }) => <Textfield {...fieldProps} />}
                            </Field>
                            <Field label="Email" name="my-email" defaultValue="">
                                {({ fieldProps }) => (
                                    <Textfield
                                        autoComplete="off"
                                        placeholder="gbelson@hooli.com"
                                        {...fieldProps}
                                    />
                                )}
                            </Field>

                            <CheckboxField name="checkbox" defaultIsChecked>
                                {({ fieldProps }) => (
                                    <Checkbox {...fieldProps} value="example" label="Checkbox" />
                                )}
                            </CheckboxField>

                            <Field name="radiogroup" defaultValue="">
                                {({ fieldProps: { value, ...others } }) => (
                                    <RadioGroup
                                        items={radioItems}
                                        label="Basic Radio Group Example"
                                        {...others}
                                    >
                                        <AkRadio name="standalone" value="singleButton">
                                            Radio button
                                        </AkRadio>
                                    </RadioGroup>
                                )}
                            </Field>
                        </ModalDialog>
                </ModalTransition>
            </div>
        );
    }
}

export default AddIssueContactDialog;