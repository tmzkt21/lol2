<template>
    <v-app id="inspire">
        <v-navigation-drawer
                v-model="drawer"
                app
                clipped
        >
            <v-list dense>
                <v-list-item
                        v-for="item in items"
                        :key="item.text"
                        link
                >
                    <v-list-item-action>
                        <v-icon>{{ item.icon }}</v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>
                            {{ item.text }}
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
                <v-subheader class="mt-4 grey--text text--darken-1">SUBSCRIPTIONS</v-subheader>
                <v-list>
                    <v-list-item
                            v-for="item in items2"
                            :key="item.text"
                            link
                    >
                        <v-list-item-avatar>
                            <img
                                    :src="`https://randomuser.me/api/portraits/men/${item.picture}.jpg`"
                                    alt=""
                            >
                        </v-list-item-avatar>
                        <v-list-item-title v-text="item.text"></v-list-item-title>
                    </v-list-item>
                </v-list>
                <v-list-item
                        class="mt-4"
                        link
                >
                    <v-list-item-action>
                        <v-icon color="grey darken-1">mdi-plus-circle-outline</v-icon>
                    </v-list-item-action>
                    <v-list-item-title class="grey--text text--darken-1">Browse Channels</v-list-item-title>
                </v-list-item>
                <v-list-item link>
                    <v-list-item-action>
                        <v-icon color="grey darken-1">mdi-cog</v-icon>
                    </v-list-item-action>
                    <v-list-item-title class="grey--text text--darken-1">Manage Subscriptions</v-list-item-title>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>

        <v-app-bar
                app
                clipped-left
                color="red"
                dense
        >
            <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

            <v-icon
                    class="mx-4"
                    large
            >
                mdi-youtube
            </v-icon>
            <v-toolbar-title class="mr-12 align-center">
                <span class="title">비트케어</span>
            </v-toolbar-title>
            <v-spacer></v-spacer>
            <v-row
                    align="center"
                    style="max-width: 650px"
            >

                <input type="text"
                       :append-icon-cb="() => {}"
                       placeholder="입력란"
                       id="search"
                       v-model="searchWord"
                       single-line
                       append-icon="mdi-magnify"
                       color="white"
                       hide-details>

                <input @click="search"
                        id="google_search"
                        type="button"
                        value="검색"/>


            </v-row>
        </v-app-bar>

        <v-main>
            <v-container class="fill-height">
                <v-row
                        justify="center"
                        align="center"
                >
                    <v-col class="shrink">
                        <v-tooltip right>
                        </v-tooltip>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
        <h3>검색된 키워드: {{ searchWord }}</h3>
    </v-app>
</template>

<script>
    export default {
        props: {
            source: String,
        },
        data1() {
            return {
                searchWord: ""
            };
        },

        data: () => ({
            drawer: null,
            items: [
                { icon: 'mdi-trending-up', text: 'Home' },
                { icon: 'mdi-youtube-subscription', text: '요양사리스트' },
                { icon: 'mdi-history', text: '요양사의유래' },
                { icon: 'mdi-playlist-play', text: '공백' },
                { icon: 'mdi-clock', text: '공백' },
            ],
            items2: [
                { picture: 28, text: 'A' },
                { picture: 38, text: 'B' },
                { picture: 48, text: 'C' },
                { picture: 58, text: 'D' },
                { picture: 78, text: 'E' },
            ],

        }),
        methods: {
            search() {
                // switch (this.searchWord) {
                // case this.searchWord === "요양사리스트" :this.$store.dispatch("search/list", this.searchWord);
                //     alert("검색단어:"+ this.searchWord);
                // }
                if(this.searchWord === '요양사리스트'){
                    this.$store.dispatch("search/list", this.searchWord);
                }

            }
        }
        // created () {
        //     this.$vuetify.theme.dark = true
        // },
    }
</script>