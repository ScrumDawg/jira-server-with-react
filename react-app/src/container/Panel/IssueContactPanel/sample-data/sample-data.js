// @flow
/* sample-data.js */
import React from 'react';
import Avatar from '@atlaskit/avatar';
import DropdownMenu, {
    DropdownItemGroup,
    DropdownItem,
} from '@atlaskit/dropdown-menu';
import styled from 'styled-components';
import persons from './persons.json';
import companies from './companies.json';

function createKey(input) {
    return input ? input.replace(/^(the|a|an)/, '').replace(/\s/g, '') : input;
}

const NameWrapper = styled.span`
  display: flex;
  align-items: center;
`;

const AvatarWrapper = styled.div`
  margin-right: 8px;
`;



export const caption = 'Persons';

export const createHead = (withWidth) => {
    return {
        cells: [
            {
                key: 'name',
                content: 'Name',
                isSortable: true,
                width: 33,
            },
            {
                key: 'email',
                content: 'Email',
                shouldTruncate: true,
                isSortable: true,
                width: 33,
            },
            {
                key: 'telephone',
                content: 'Tel.',
                shouldTruncate: true,
                isSortable: true,
                width: 33,
            },
            {
                key: 'more',
                shouldTruncate: true,
            },
        ],
    };
};

export const head = createHead(true);

export const rowsPerson = persons.map((person, index) => ({
    key: `row-${index}-${person.name}`,
    cells: [
        {
            key: createKey(person.name),
            content: (
                <NameWrapper>
                    <AvatarWrapper>
                        <Avatar
                            name={person.name}
                            size="medium"
                            src={`https://api.adorable.io/avatars/24/${encodeURIComponent(
                                person.name,
                            )}.png`}
                        />
                    </AvatarWrapper>
                    <a href="https://atlassian.design">{person.name}</a>
                </NameWrapper>
            ),
        },
        {
            key: createKey(person.email),
            content: person.email,
        },
        {
            key: person.id,
            content: person.telephone,
        },
    ],
}));

export const rowsCompany = companies.map((company, index) => ({
    key: `row-${index}-${company.name}`,
    cells: [
        {
            key: createKey(company.name),
            content: (
                <NameWrapper>
                    <AvatarWrapper>
                        <Avatar
                            name={company.name}
                            size="medium"
                            src={`https://api.adorable.io/avatars/24/${encodeURIComponent(
                                company.name,
                            )}.png`}
                        />
                    </AvatarWrapper>
                    <a href="https://atlassian.design">{company.name}</a>
                </NameWrapper>
            ),
        },
        {
            key: createKey(company.email),
            content: company.email,
        },
        {
            key: company.id,
            content: company.telephone,
        },
    ],
}));
