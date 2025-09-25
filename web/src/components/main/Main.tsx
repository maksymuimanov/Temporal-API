import {HeadingContainer} from "@/components/main/home/heading/HeadingContainer.tsx";
import {CardContainer} from "@/components/main/home/card/CardContainer.tsx";
import {ShowcaseContainer} from "@/components/main/home/showcase/ShowcaseContainer.tsx";

export const Main = () => {
    return (
        <main>
            <HeadingContainer />
            <CardContainer />
            <ShowcaseContainer />
        </main>
    );
};