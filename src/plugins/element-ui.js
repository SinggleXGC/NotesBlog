import Vue from "vue";
import {
    Container, Footer, Header, Main, Aside,
    Menu, MenuItem, Submenu,
    Input, Button,
    Divider, Col, Row,
    Tag
} from "element-ui";

import ElScrollBar from 'element-ui/lib/scrollbar'

Vue.use(Container).use(Header).use(Main).use(Footer).use(Aside)
    .use(Menu).use(MenuItem).use(Submenu)
    .use(Input).use(Button)
    .use(Divider).use(Col).use(Row)
    .use(Tag).use(ElScrollBar)
